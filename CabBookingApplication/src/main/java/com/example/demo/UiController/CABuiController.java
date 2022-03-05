package com.example.demo.UiController;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.Entity.Cabre;
import com.example.demo.ServiceImplementation.CabRegistrationImpl;

@Controller
public class CABuiController {

	@Autowired
	CabRegistrationImpl impl; // object of cab implementation

	@GetMapping("/loadcabform") // load empty cab form
	public String loadf(Model model, Cabre cabre) {
		try {
			model.addAttribute("cab", cabre);
			return "addcab";
		} catch (Exception e) {
			e.printStackTrace();
			return "something went Wrong";
		}
	}

	@PostMapping("/sdata") // save cab
	public String savedata(Model model, Cabre cabre) {
		try {
			impl.AddCab(cabre);
			return "redirect:/loadcabform";
		} catch (Exception e) {
			e.printStackTrace();
			return "something wrong data enter";
		}
	}

	@GetMapping("/allCablist") // display all cab admin
	public String printall1(Model model) {
		try {
			List<Cabre> l2 = impl.Displayall();
			model.addAttribute("cab", l2);
			return "Cab";
		} catch (Exception e) {
			e.printStackTrace();
			return "Cab Not Available";
		}

	}
	
	
	@GetMapping("/delte1{id}") // delete cab by using id
	public String delete1(@PathVariable int id) {
		try {

			impl.DeleteCabById(id);
			return "redirect:/allCablist";
		} catch (Exception e) {
			e.printStackTrace();
			return "Invalid Id";
		}
	}

	@GetMapping("/countoftype1") // localhost:8099/countoftype?carType=iritka

	public String cabtype1(@RequestParam(required = false) String carType, Model model) {
		try {
			int size = impl.cabOfCountType(carType);
			System.out.println(size);

			model.addAttribute("k", size);
			return "count";
		} catch (Exception e) {
			e.printStackTrace();
			return "Type is inavlid";
		}
	}

	@GetMapping("displaydata2") // localhost:8099/displaydata?CabType=ola for API
	@ResponseBody
	public List<Cabre> showdata2(@RequestParam(required = false) String CabType, Model model) {
		try {

			return impl.ViewCabOfType(CabType);
		} catch (Exception e) {
			List<Cabre> cablst=new ArrayList<>();
			Cabre c=new Cabre();
			c.setCartype(e.getMessage());
			cablst.add(c);
			return cablst;
		}
	}
}
