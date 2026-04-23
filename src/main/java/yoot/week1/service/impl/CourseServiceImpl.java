package yoot.week1.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yoot.week1.domain.entity.Course;
import yoot.week1.dto.request.UpdateCourseRequest;
import yoot.week1.repository.CourseRepository;
import yoot.week1.service.CourseService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    public List<Course> findAll(){
        return courseRepository.findAll();
    }

    public Optional<Course> findById(Long id){
        return courseRepository.findById(id);
    }

    public boolean existById(Long id){
        return courseRepository.existsById(id);
    }

    public Course save(Course course){
        return courseRepository.save(course);
    }

    public void delete(Long courseId){
        courseRepository.deleteById(courseId);
    }

    public Course updateCourse(Long id, UpdateCourseRequest request){
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not exist"));
        if(request.name()!=null){
            course.setName(request.name());
        }

        if(request.courseCode()!=null){
            course.setCourseCode(request.courseCode());
        }

        if(request.description()!=null){
            course.setDescription(request.description());
        }

        if(request.active() != null){
            course.setActive(request.active());
        }

        if(request.totalSessions()!= null){
            course.setTotalSessions(request.totalSessions());
        }
        if (request.tuitionFee() != null){
            course.setTuitionFee(request.tuitionFee());
        }
        return courseRepository.save(course);
    }

}
