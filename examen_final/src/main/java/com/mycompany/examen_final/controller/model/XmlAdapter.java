/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examen_final.controller.model;

/**
 *
 * @author Eddier Lopez
 */


//XML eXtensible Markup Language 
//(Lenguaje de Marcado Extensible
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.DOMImplementation;


public class XmlAdapter {
    protected String url;
    public XmlAdapter(String entityName){
        this.url=entityName+".xml";       
    }

    protected void transformXML(Document doc) throws Exception{
        Result file=new StreamResult(new File(this.url));
        Source source=new DOMSource(doc);
        Transformer transformer=
                TransformerFactory.newInstance()
                        .newTransformer();
        transformer.transform(source, file);
    }
    public Document getNormalized() throws Exception{
        Document doc=DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(this.url);
        doc.getDocumentElement().normalize();
        return doc;
    }
}
