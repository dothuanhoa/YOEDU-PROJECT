package yoot.week1.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yoot.week1.common.exception.NotFoundException;
import yoot.week1.domain.entity.CourseClass;
import yoot.week1.domain.entity.Student;
import yoot.week1.domain.enums.ClassStatus;
import yoot.week1.dto.courseclass.CourseClassResponse;
import yoot.week1.dto.courseclass.CourseClassUpsertRequest;
import yoot.week1.repository.*;
import yoot.week1.service.CourseClassService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseClassServiceImpl implements CourseClassService {
    private final CourseClassRepository courseClassRepository;
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    private final ScheduleSlotRepository scheduleSlotRepository;
    private final ModelMapper mapper;
    private final RoomRepository roomRepository;

    private CourseClassResponse toClassResponse(CourseClass cc){
        return mapper.map(cc, CourseClassResponse.class);
    }

    private void copyToCourseClass(CourseClass cc , CourseClassUpsertRequest req){
        mapper.map(req, cc);
        if (req.getCourseId() != null){
            courseRepository.findById(req.getCourseId())
                    .ifPresent(cc::setCourse);
        }

        if(req.getScheduleSlotId() !=null){
            scheduleSlotRepository.findById(req.getScheduleSlotId())
                    .ifPresent(cc::setScheduleSlot);
        }

        if(req.getRoomId() != null){
            roomRepository.findById(req.getRoomId())
                    .ifPresent(cc::setRoom);
        }

        if(req.getMainTeacherId() !=null){
            teacherRepository.findById(req.getMainTeacherId())
                    .ifPresent(cc::setMainTeacher);
        }

        if(req.getAssistantTeacherId() !=null){
            teacherRepository.findById(req.getAssistantTeacherId())
                    .ifPresent(cc::setAssistantTeacher);
        }
    }

    @Transactional(readOnly = true)
    //để load lên những thông tin lazy
    //get phải lấy object nên phải throw exception, còn find có thể optional
    public CourseClass getCourseClass(Long id) throws NotFoundException {
        return courseClassRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Course class not found: " + id));
    }


    public List<CourseClassResponse> findAll(){
        return courseClassRepository.findAll().stream()
                .map(this::toClassResponse)
                .toList();
    }

    public List<CourseClassResponse> findAll(ClassStatus status){
        return courseClassRepository.findAllByStatus(status).stream()
                .map(this::toClassResponse)
                .toList();
    }

    public Optional<CourseClassResponse> findById(long id){
        return courseClassRepository.findById(id)
                .map(this::toClassResponse);
    }

    public CourseClassResponse create(CourseClassUpsertRequest request){
        CourseClass cc = mapper.map(request, CourseClass.class);
        copyToCourseClass(cc, request);

        return toClassResponse(courseClassRepository.save(cc));
    }

    public CourseClassResponse update(Long id, CourseClassUpsertRequest request){
        Optional<CourseClass> courseClass = courseClassRepository.findById(id);

        if(courseClass.isPresent()){
            CourseClass cc = courseClass.get();
            copyToCourseClass(cc, request);

            return toClassResponse(courseClassRepository.save(cc));
        }else{
            throw new NotFoundException("Course not exists");
        }
    }
    public void delete(long id){
        courseClassRepository.deleteById(id);
    }
}
