/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examen_final.controller;

import com.mycompany.examen_final.controller.model.Consultas;
import com.mycompany.examen_final.controller.model.ConsultasDAO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eddier Lopez
 */
public class ConsultasController implements ConsultasInterface{
    ConsultasDAO dao;
    public ConsultasController(){       
        dao=new ConsultasDAO("Acceso");       
    }
    
    //busqueda por medio de la etiqueta descripcion y obtiene todo su contenido
    @Override
    public String[][] Compañia(String type, String arg) {
        try{
            ArrayList<Consultas> list;
            if(type.equals("compañia")){
                list=dao.getByCompañia(arg);
            }else{
                list=dao.getByRol(arg);
            }
            String[][] data=new String[list.size()][6];
            for(int i=0;i<list.size();i++){
                data[i][0]=list.get(i).getUsuario();
                data[i][1]=list.get(i).getRol();
                data[i][2]=list.get(i).getNombre().toString();
                data[i][3]=list.get(i).getCompañia();
                data[i][4]=list.get(i).getCorreo();
                data[i][5]=list.get(i).getLocalizacion();
                
            }
            return data;
        }catch(Exception ex){
            return null;
        }
    }
    // se realiza la busqueda por medio de un filtro llamado distrito
    @Override
    public String[] getRol() {
        try {
            List list=dao.listOfRol();
            String[] data=new String[list.size()];
            for(int i=0;i<list.size();i++){
                data[i]=list.get(i).toString();
            }
            return data;
        } catch (Exception ex) {
            return null;
        }
    }
    
}
