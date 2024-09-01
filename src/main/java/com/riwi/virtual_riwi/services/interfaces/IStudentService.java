package com.riwi.virtual_riwi.services.interfaces;

import com.riwi.virtual_riwi.dtos.request.student.StudentRequest;
import com.riwi.virtual_riwi.dtos.response.student.StudentResponse;
import com.riwi.virtual_riwi.entities.StudentEntitys;
import com.riwi.virtual_riwi.services.crud.*;

public interface IStudentService extends
        CreateService<StudentRequest, StudentEntitys>,
        UpdateService<StudentRequest, StudentEntitys, Long>,
        ReadAllService<StudentResponse>,
        ReadByIdService<StudentResponse, Long>,
        ArchiveService<Long>,
        PageAllElementServiceName<StudentEntitys, String, Integer, Integer>{

}
