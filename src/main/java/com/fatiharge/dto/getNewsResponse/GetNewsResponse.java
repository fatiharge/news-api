package com.fatiharge.dto.getNewsResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;
@AllArgsConstructor
@Builder
public class GetNewsResponse {
    @JsonProperty("meta")
    public GetNewsMeta getNewsMeta;
    @JsonProperty("data")
    public List<GetNewsData> getNewsDataList;
}
