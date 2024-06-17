/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examen_final.controller;

import com.una.examenresolucion.model.Permit;
import com.una.examenresolucion.model.PermitDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eddier Lopez
 */
public class PermitController implements PermitInterface{
    PermitDAO dao;
    public PermitController(){       
        dao=new PermitDAO("permisos");       
    }
    
    //busqueda por medio de la etiqueta descripcion y obtiene todo su contenido
    @Override
    public String[][] query(String type, String arg) {
        try{
            ArrayList<Permit> list;
            if(type.equals("description")){
                list=dao.getByDescription(arg);
            }else{
                list=dao.getByDistrict(arg);
            }
            String[][] data=new String[list.size()][5];
            for(int i=0;i<list.size();i++){
                data[i][0]=list.get(i).getNumber();
                data[i][1]=list.get(i).getArea().toString();
                data[i][2]=list.get(i).getDescription();
                data[i][3]=list.get(i).getDistrict();
                data[i][4]=list.get(i).getApprovalDate();
                
            }
            return data;
        }catch(Exception ex){
            return null;
        }
    }
    // se realiza la busqueda por medio de un filtro llamado distrito
    @Override
    public String[] getDistricts() {
        try {
            List list=dao.listOfDistricts();
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
