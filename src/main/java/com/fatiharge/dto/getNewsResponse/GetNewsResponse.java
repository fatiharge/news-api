package com.fatiharge.dto.getNewsResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

import java.util.List;
@AllArgsConstructor
public class GetNewsResponse {
    @JsonProperty("data")
    public List<GetNewsData> getNewsDataList;
}
