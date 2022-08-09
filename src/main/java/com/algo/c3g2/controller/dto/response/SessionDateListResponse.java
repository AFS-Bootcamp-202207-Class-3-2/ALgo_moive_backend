package com.algo.c3g2.controller.dto.response;

import com.algo.c3g2.entity.Session;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SessionDateListResponse {
    private HashMap<String, List<Session>> sessionDateList;
}