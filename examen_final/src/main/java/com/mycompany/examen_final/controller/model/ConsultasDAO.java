/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examen_final.controller.model;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Eddier Lopez
 */
public class ConsultasDAO extends XmlAdapter{
    
    public ConsultasDAO(String entityName){
        super(entityName);
    }
    public ArrayList<Consultas> getByCompañia(String param) throws Exception{
        ArrayList<Consultas> data=new ArrayList<>();
        NodeList list=this.getNodeList("Acceso");
        for(int i=0;i<list.getLength();i++){
            if(list.item(i).getChildNodes().item(2).getTextContent().startsWith(param)){
                data.add(this.elementToPermit(list.item(i)));
            }
        }
        return data;
    }
    public ArrayList<Consultas> getByRol(String district) throws Exception{
        ArrayList<Consultas> data=new ArrayList<>();
        NodeList list=this.getNodeList("Acceso");
        for(int i=0;i<list.getLength();i++){
            if(list.item(i).getChildNodes().item(3).getTextContent().equals(district)){
                data.add(this.elementToPermit(list.item(i)));
            }
        }
        return data;
    }
    public List listOfRol() throws Exception{        
        NodeList list=this.getNodeList("Rol");
        List data=new ArrayList();
        for(int i=0;i<list.getLength();i++){
            if(!data.contains(list.item(i).getTextContent())){
               data.add(list.item(i).getTextContent());
            }
        }
        return data;
    }
    private NodeList getNodeList(String tag) throws Exception{
        return this.getNormalized().getDocumentElement().getElementsByTagName(tag);
    }
    private Consultas elementToPermit(Node node){
        return new Consultas(
                node.getChildNodes().item(0).getTextContent(),
                Double.valueOf(node.getChildNodes().item(1).getTextContent()),
                node.getChildNodes().item(2).getTextContent(),
                node.getChildNodes().item(3).getTextContent(),
                node.getChildNodes().item(4).getTextContent()
        );
    }
    
}
