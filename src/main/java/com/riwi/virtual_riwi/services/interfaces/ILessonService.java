package com.riwi.virtual_riwi.services.interfaces;

import com.riwi.virtual_riwi.dtos.request.lesson.LessonRequest;
import com.riwi.virtual_riwi.dtos.response.lesson.LessonResponse;
import com.riwi.virtual_riwi.entities.LessonEntity;
import com.riwi.virtual_riwi.services.crud.ArchiveService;
import com.riwi.virtual_riwi.services.crud.CreateService;
import com.riwi.virtual_riwi.services.crud.ReadByIdService;

public interface ILessonService extends
        CreateService<LessonRequest, LessonEntity>,
        ReadByIdService<LessonResponse, Long>,
        ArchiveService<Long> {
}
