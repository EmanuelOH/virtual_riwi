package com.riwi.virtual_riwi.controllers.interfaces;

import com.riwi.virtual_riwi.controllers.generic.*;
import com.riwi.virtual_riwi.dtos.request.student.StudentRequest;
import com.riwi.virtual_riwi.dtos.response.student.StudentResponse;
import com.riwi.virtual_riwi.entities.StudentEntitys;
import com.riwi.virtual_riwi.services.crud.*;

public interface IStudentController extends
        CreateController<StudentRequest, StudentEntitys>,
        UpdateController<StudentRequest, StudentEntitys, Long>,
        ReadAllController<StudentResponse>,
        ReadByIdController<StudentResponse, Long>,
        ArchiveController<Long>,
        PageAllElementControllerName<StudentEntitys, String, Integer, Integer>{
}
