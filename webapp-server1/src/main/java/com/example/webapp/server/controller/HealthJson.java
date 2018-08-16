package com.example.webapp.server.controller;

public class HealthJson{
    private String status;
    public String getStatus(){
        return this.status;
    }

    public void setStatus(String status){
        this.status=status;
    }
}