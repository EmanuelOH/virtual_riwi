package com.riwi.virtual_riwi.services.interfaces;

import com.riwi.virtual_riwi.dtos.request.multi_media.MultiMediaRequest;
import com.riwi.virtual_riwi.dtos.response.multi_media.MultiMediaResponse;
import com.riwi.virtual_riwi.entities.MultiMediaEntity;
import com.riwi.virtual_riwi.services.crud.CreateService;
import com.riwi.virtual_riwi.services.crud.ReadByIdService;

public interface IMultiMediaService extends
        CreateService<MultiMediaRequest, MultiMediaEntity>,
        ReadByIdService<MultiMediaResponse, Long> {
}
