package com.example.invoices.Invoice;

import java.util.List;
import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/invoices")
@Controller
@RequiredArgsConstructor
public class InvoiceController {

  public List<Invoice> invoices = new ArrayList<>();

  @GetMapping("/list")
  public String getAllInvoices(Model model){
    model.addAttribute("listOfInvoices", invoices);
    return "invoices";
  }

  @PostMapping("/create")
  public String createInvoice(Model model, @ModelAttribute Invoice invoice){
    invoices.add(invoice);
    model.addAttribute("createdInvoice", invoice);
    return "invoicesHomePage";
  }

  @GetMapping("/create")
  public String createInvoice(Model model){
    model.addAttribute("createdInvoice", new Invoice());
    return "invoiceCreator";
  }

}
