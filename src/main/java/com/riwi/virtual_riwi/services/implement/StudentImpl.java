package com.riwi.virtual_riwi.services.implement;

import com.riwi.virtual_riwi.dtos.request.student.StudentRequest;
import com.riwi.virtual_riwi.dtos.response.student.StudentResponse;
import com.riwi.virtual_riwi.entities.StudentEntitys;
import com.riwi.virtual_riwi.repositories.interfaces.StudentRepository;
import com.riwi.virtual_riwi.services.interfaces.IStudentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentImpl implements IStudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public void archive(Long id) {
        StudentEntitys student = studentRepository.findById(id).orElseThrow();

        student.setActive(false);
        studentRepository.save(student);
    }

    @Transactional
    @Override
    public StudentEntitys create(StudentRequest studentRequest) {
        StudentEntitys request = StudentEntitys.builder()
                .name(studentRequest.getName())
                .last_name(studentRequest.getLast_name())
                .age(studentRequest.getAge())
                .email(studentRequest.getEmail())
                .createAt(studentRequest.getCreateAt())
                .classEntity(studentRequest.getClassEntity()).build();

        return studentRepository.save(request);
    }
    
    @Override
    public List<StudentResponse> readAll() {
        List<StudentEntitys> listStudent = studentRepository.findAll();

        List<StudentResponse> studentResponseList = new ArrayList<>();

        for(StudentEntitys student: listStudent){
            StudentResponse studentResponse = new StudentResponse();

            studentResponse.setId(student.getId());
            studentResponse.setName(student.getName());
            studentResponse.setLast_name(student.getLast_name());
            studentResponse.setAge(student.getAge());
            studentResponse.setEmail(student.getEmail());
            studentResponse.setCreateAt(student.getCreateAt());
            studentResponse.setActive(student.getActive());

            studentResponseList.add(studentResponse);
        }
        return studentResponseList;
    }

    @Override
    public StudentResponse readById(Long id) {
        StudentEntitys student = studentRepository.findById(id).orElseThrow();

        StudentResponse studentResponse = new StudentResponse();

        studentResponse.setId(student.getId());
        studentResponse.setName(student.getName());
        studentResponse.setLast_name(student.getLast_name());
        studentResponse.setAge(student.getAge());
        studentResponse.setEmail(student.getEmail());
        studentResponse.setCreateAt(student.getCreateAt());
        studentResponse.setCreateAt(student.getCreateAt());

        return studentResponse;
    }

    @Override
    public StudentEntitys update(StudentRequest studentRequest, Long id) {
        StudentEntitys existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found with id: " + id));

        existingStudent.setName(studentRequest.getName());
        existingStudent.setLast_name(studentRequest.getLast_name());
        existingStudent.setAge(studentRequest.getAge());
        existingStudent.setEmail(studentRequest.getEmail());
        existingStudent.setCreateAt(studentRequest.getCreateAt());
        existingStudent.setClassEntity(studentRequest.getClassEntity());

        return studentRepository.save(existingStudent);
    }

    @Override
    public Page<StudentEntitys> pageAllElementName(String name, Integer page, Integer size) {
        return studentRepository.pageAllElement(name, PageRequest.of(page, size));
    }
}
