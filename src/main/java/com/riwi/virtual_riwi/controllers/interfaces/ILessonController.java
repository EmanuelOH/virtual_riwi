package com.riwi.virtual_riwi.controllers.interfaces;

import com.riwi.virtual_riwi.controllers.generic.ArchiveController;
import com.riwi.virtual_riwi.controllers.generic.CreateController;
import com.riwi.virtual_riwi.controllers.generic.ReadByIdController;
import com.riwi.virtual_riwi.dtos.request.lesson.LessonRequest;
import com.riwi.virtual_riwi.dtos.response.lesson.LessonResponse;
import com.riwi.virtual_riwi.entities.LessonEntity;

public interface ILessonController extends
        CreateController<LessonRequest, LessonEntity>,
        ReadByIdController<LessonResponse, Long>,
        ArchiveController<Long> {
}
