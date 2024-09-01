package com.riwi.virtual_riwi.controllers.interfaces;

import com.riwi.virtual_riwi.controllers.generic.CreateController;
import com.riwi.virtual_riwi.controllers.generic.ReadByIdController;
import com.riwi.virtual_riwi.dtos.request.multi_media.MultiMediaRequest;
import com.riwi.virtual_riwi.dtos.response.multi_media.MultiMediaResponse;
import com.riwi.virtual_riwi.entities.MultiMediaEntity;

public interface IMultiMediaController extends
        CreateController<MultiMediaRequest, MultiMediaEntity>,
        ReadByIdController<MultiMediaResponse, Long> {
}
