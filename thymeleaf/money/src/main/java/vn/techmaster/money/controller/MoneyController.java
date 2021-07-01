package vn.techmaster.money.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.techmaster.money.model.CurrencyRate;
import vn.techmaster.money.request.MoneyConvertRequest;
import vn.techmaster.money.response.MoneyConverterResponse;
import vn.techmaster.money.service.MoneyConverter;


@Controller
public class MoneyController {

  @Autowired
  private MoneyConverter moneyConverter;

  @GetMapping("/money")
  public String renderForm(Model model) {
    model.addAttribute("moneyConvertRequest", new MoneyConvertRequest());

    List<CurrencyRate> currencies = moneyConverter.getSortedCurrencyCode();
    
    model.addAttribute("currencies", currencies);  
    return "form";
  }
  
  @PostMapping("/money")
  public String getResultForm(MoneyConvertRequest request, BindingResult result, Model model) {
    if (!result.hasErrors()) {
      MoneyConverterResponse response = moneyConverter.getConvertResponse(request);
      model.addAttribute("convertResultss", response);
    }
    return "convert";
  }
}
