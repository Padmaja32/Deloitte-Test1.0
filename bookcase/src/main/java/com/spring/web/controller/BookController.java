package com.spring.web.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.web.dao.BookDAO;
import com.spring.web.entity.Book;
@Controller
public class BookController 
{
	BookDAO bdao;
	@Autowired
	BookController(BookDAO bdao)
	{
		this.bdao=bdao;
	}
	@GetMapping("/bPage")
		public String getempPage(Model model)
		{
		model.addAttribute("b",new Book(0,"","",0));
		return "DisplayBook";
	    }
	@GetMapping("/bCRUD")
	public String bCrud(@RequestParam("sub")String sub,@RequestParam("id")int id ,@RequestParam("tittle")String tittle,
			@RequestParam("author")String author,@RequestParam("price")double price,RedirectAttributes ra)
	{
		ra.addFlashAttribute("b",new Book(id,tittle,author,price));
		String val= "";
		if(sub.equals("Add_Book")) val="addBook";
		else if(sub.equals("Del_Book")) val="deleteBook";
		else if(sub.equals("Modify_Book")) val="modifyBook";
		else val="getBook";
		return "redirect:"+val;
	}
	@GetMapping("/addBook")
		public String addBook(@ModelAttribute("b")Book b)
		{
		bdao.insertBook(new Book(b.getId(),b.getTittle(),b.getAuthor(),b.getPrice()));
		return "DisplayBook";
	}
	@GetMapping("/modifyBook")
	public String modifyBook(@ModelAttribute("b")Book b)
	{
		bdao.modifyBook(b);
		return "DisplayBook";
	}
	@GetMapping("/deleteBook")
	public String deleteBook(@ModelAttribute("b")Book b)
	{
		bdao.deleteBook(b.getId());
		return "DisplayBook";
	}
	@GetMapping("/getBook")
	public String getBook(@ModelAttribute("b")Book b,Model model)
	{
		Book b1 = bdao.getBook(b.getId());
		model.addAttribute("b",b1);
		return "DisplayBook";
	}
				
	}
	
	
	
	
	

