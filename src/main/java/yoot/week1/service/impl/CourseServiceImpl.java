package yoot.week1.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import yoot.week1.common.exception.NotFoundException;
import yoot.week1.domain.entity.Course;
import yoot.week1.dto.course.CourseResponse;
import yoot.week1.dto.course.CourseUpsertRequest;
import yoot.week1.repository.CourseRepository;
import yoot.week1.service.CourseService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    private CourseResponse map(Course course){
        return modelMapper.map(course, CourseResponse.class);
    };

    public List<CourseResponse> findAll(){
        return courseRepository.findAll().stream().map(this::map).toList();
    }

    public Optional<CourseResponse> findById(Long id){
        return courseRepository.findById(id)
                .map(this::map);
    }

    public CourseResponse create(CourseUpsertRequest request){
        Course c = modelMapper.map(request, Course.class);
        c.setCreatedAt(LocalDateTime.now());
        c.setUpdatedAt(LocalDateTime.now());

        return map(courseRepository.save(c));
    }

    public CourseResponse update(Long id, CourseUpsertRequest request){
        Course c = modelMapper.map(request, Course.class);
        c.setId(id);
        c.setCreatedAt(LocalDateTime.now());
        c.setUpdatedAt(LocalDateTime.now());

        return map(courseRepository.save(c));
    }

    public void delete(Long id){
        if (courseRepository.existsById(id)){
            courseRepository.deleteById(id);
        }
        else {
            throw new NotFoundException("Delete error (not found) id: "+id);
        }
    }
}
