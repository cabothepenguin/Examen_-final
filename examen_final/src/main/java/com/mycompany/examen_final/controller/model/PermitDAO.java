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
public class PermitDAO extends XmlAdapter{
    
    public PermitDAO(String entityName){
        super(entityName);
    }
    public ArrayList<Permit> getByDescription(String param) throws Exception{
        ArrayList<Permit> data=new ArrayList<>();
        NodeList list=this.getNodeList("permiso");
        for(int i=0;i<list.getLength();i++){
            if(list.item(i).getChildNodes().item(2).getTextContent().startsWith(param)){
                data.add(this.elementToPermit(list.item(i)));
            }
        }
        return data;
    }
    public ArrayList<Permit> getByDistrict(String district) throws Exception{
        ArrayList<Permit> data=new ArrayList<>();
        NodeList list=this.getNodeList("permiso");
        for(int i=0;i<list.getLength();i++){
            if(list.item(i).getChildNodes().item(3).getTextContent().equals(district)){
                data.add(this.elementToPermit(list.item(i)));
            }
        }
        return data;
    }
    public List listOfDistricts() throws Exception{        
        NodeList list=this.getNodeList("distrito");
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
    private Permit elementToPermit(Node node){
        return new Permit(
                node.getChildNodes().item(0).getTextContent(),
                Double.valueOf(node.getChildNodes().item(1).getTextContent()),
                node.getChildNodes().item(2).getTextContent(),
                node.getChildNodes().item(3).getTextContent(),
                node.getChildNodes().item(4).getTextContent()
        );
    }
    
}
