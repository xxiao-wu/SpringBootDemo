package com.example.demo.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseBody {
    private int code;
    private String name;
    private int id;

    public ResponseBody(int code, int id, String name) {
        this.code=code;
        this.id=id;
        this.name=name;
    }
}
