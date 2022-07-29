package com.javatpoint.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javatpoint.beans.download;
import com.javatpoint.dao.DownloadDao;

@Controller
public class DownloadController {
	public String ip;
	public String viewkey;
	public String downloadURL;
	@Autowired    
    DownloadDao dao;//will inject dao from XML file  
	
	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}
    
    /*It displays a form to input data, here "command" is a reserved request attribute  
     *which is used to display object data into form  
     */    
    @RequestMapping("/downloadform")    
    public String showform(Model m){    
        m.addAttribute("command", new download());  
        return "downloadform";   
    }    
    /*It saves object into database. The @ModelAttribute puts request data  
     *  into model object. You need to mention RequestMethod.POST method   
     *  because default request is GET*/    
    @RequestMapping(value="/save",method = RequestMethod.POST)    
    public String save(@ModelAttribute("dl") download dl, HttpServletRequest req){ 
    	
    	String originalLink = dl.getYt_link();
    	String key = originalLink.substring(originalLink.lastIndexOf("=")+1);
    	viewkey = key;
    	downloadURL = "https://ytdl.hamsterlabs.de/?url=https%3A%2F%2Fwww.youtube.com%2Fwatch%3Fv%3D" + key; 
    	try {
			Document doc = Jsoup.connect(downloadURL).get();
			Elements formats = doc.select("body > div > table.formats > tbody > tr:nth-child(2) > td:nth-child(6) > a");
			System.out.println(formats.attr("abs:href"));
			downloadURL= formats.attr("abs:href");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String user_ip = req.getParameter("user_ip");
    	ip = user_ip;
    	dao.save(dl);    
        return "redirect:/viewdownload";//will redirect to viewemp request mapping    
    }    
    
    @RequestMapping("/getip")
    public String getip(Model m, HttpServletRequest req){
    	
    	String user_ip = req.getParameter("user_ip2");
    	ip = user_ip;
    	
    	return "redirect:/viewdownload"; 
    }
    
	
    /* It provides list of employees in model object */    
    @RequestMapping("/viewdownload")
    public String viewemp(Model m, HttpServletRequest req){
  
    	m.addAttribute("key",viewkey);
    	m.addAttribute("downloadURL",downloadURL);
    	System.out.println(ip);
        List<download> list=dao.getDownloads(ip);    
        m.addAttribute("list",list);  
        return "viewdownload";    
    }
    /* It displays object data into form for the given id.   
     * The @PathVariable puts URL data into variable.*/    
    @RequestMapping(value="/editdownload/{id}")    
    public String edit(@PathVariable int id, Model m){    
        download dl=dao.getDownloadsById(id);    
        m.addAttribute("command",dl);  
        
        return "downloadeditform";    
    }    
    /* It updates model object. */    
    @RequestMapping(value="/editsave", method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("dl") download dl){    
        dao.update(dl);    
        return "redirect:/viewdownload";    
    }    
    /* It deletes record for the given id in URL and redirects to /viewemp */    
    @RequestMapping(value="/deletedownload/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable int id){    
        dao.delete(id);    
        return "redirect:/viewdownload";    
    }     

}
