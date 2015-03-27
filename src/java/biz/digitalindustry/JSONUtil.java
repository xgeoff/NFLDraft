/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.digitalindustry;

import com.google.appengine.repackaged.org.codehaus.jackson.JsonNode;
import com.google.appengine.repackaged.org.codehaus.jackson.map.ObjectMapper;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gporemba
 */
public class JSONUtil {
    
    public static Map<String, String> JSONtoMap(Reader reader) {
        
        ObjectMapper mapper;
        JsonNode rootNode;
        //Iterator<JsonNode> elements;
        Map<String, String> jsonMap = null;
            
        try {

            mapper = new ObjectMapper();
            rootNode = mapper.readValue(reader, JsonNode.class);
            //elements = rootNode.getElements();
            jsonMap = new HashMap<String, String>(rootNode.size(), 1);
            
            processNode(rootNode, jsonMap);
        } catch (IOException ex) {
            Logger.getLogger(JSONUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return jsonMap;
    }
    
    public static void processNode(String key, JsonNode node, Map valueMap) {
        List nodes;
        Map childMap;
        Iterator it;
        Entry entry;
        JsonNode childNode;
        
        if (node.isObject() == true) {
            childMap = new HashMap();
            valueMap.put(key, childMap);
            it = node.getFields();

            while (it.hasNext() == true) {
                entry = (Entry)it.next();
                processNode((String)entry.getKey(), (JsonNode)entry.getValue(), childMap);
                
            }
            
        } else if (node.isArray() == true) {
            it = node.getElements();
            nodes = new ArrayList();
            valueMap.put(key, nodes);
            
            while (it.hasNext() == true) {
                childNode = (JsonNode)it.next();
                processNode(childNode, nodes);
            }

        } else {
            valueMap.put(key, node.getTextValue());
        }
    }
    
    public static void processNode(JsonNode node, List nodes) {
        List childList;
        Map childMap;

        //Iterator<JsonNode> itArray;
        if (node.isObject() == true) {
                childMap = new HashMap();
                nodes.add(childMap);
                processNode(node, childMap);
        } else if(node.isArray() == true) {
                childList = new ArrayList();
                nodes.add(childList);
                processNode(node, childList);
        } else {
            nodes.add(node.getTextValue());
        }

    }
    
    public static void processNode(JsonNode node, Map valueMap) {
        
        Iterator<Entry<String,JsonNode>> it;
        Entry<String, JsonNode> entry;
        
        it = node.getFields();
        
        while (it.hasNext()== true) {
            entry = it.next();
            processNode(entry.getKey(), entry.getValue(), valueMap);
        }
    }
}
