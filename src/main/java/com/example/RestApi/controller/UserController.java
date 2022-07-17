package com.example.RestApi.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.ZoneId;
import java.util.*;

import com.example.RestApi.entities.Chauffeur;
import com.example.RestApi.entities.Fournisseur;
import com.example.RestApi.entities.Msg;
import com.example.RestApi.entities.User;
import com.example.RestApi.repository.MsgRepository;
import com.example.RestApi.repository.ParcRoulantRepository;
import com.example.RestApi.repository.ReceptionRepository;
import com.example.RestApi.repository.UserRepository;

@CrossOrigin(origins = "*")
@RestController
public class UserController {

	private final UserRepository userrepo;
	private final ParcRoulantRepository ParcRoulancerepo;
	private final ReceptionRepository receptionrepo;
	private final MsgRepository msgrepo;
	UserController(UserRepository userrepo,	MsgRepository msgrepo,ParcRoulantRepository prr,ReceptionRepository receptionrepo) {
		this.userrepo = userrepo;
		this.ParcRoulancerepo = prr;
		this.receptionrepo = receptionrepo;
		this.msgrepo = msgrepo;
	}
	@CrossOrigin(origins = "*")
	@PostMapping("/login")
	public Map<String, String> loginUser(@RequestBody Map<String, String> us) {
		HashMap<String, String> map = new HashMap<>();
		User user = userrepo.findByEmail(us.get("email"));
		if (user!=null && user.getPassword().equals(us.get("pw"))) {
			map.put("role",user.getRole());
			map.put("nom",user.getNom());
		} else
			map.put("key", "false");
		return map;
	}
	
	 
	@CrossOrigin(origins = "*")
	@GetMapping("/AllGardien")
	public  List<User> AllGardien() {
		return userrepo.findByRole("gardien");
	}
	 
	
	@CrossOrigin(origins = "*")
	@GetMapping("/Alldirg")
	public  List<User> Alldirg() {
		return userrepo.findByRole("directeur-general");
	}
	 
	
	
	
	@CrossOrigin(origins = "*")
	@GetMapping("/Alldirs")
	public  List<User> Alldirs() {
		return userrepo.findByRole("directeur-site");
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/Allusers")
	public  List<User> Allusers() {
		return userrepo.findAll();
	}
	 
	@CrossOrigin(origins = "*")
	@PostMapping("/createmsg")
	public Map<String, String> createmsg(@RequestBody Map<String, String> us) {
		HashMap<String, String> maper = new HashMap<>();
		Msg msg = new Msg();
		msg.setMsg(us.get("msg"));
		msg.setSender(us.get("sen"));
		msg.setReciver(us.get("rec"));
		msg.setDate(new Date());
		msgrepo.save(msg);
		maper.put("key", "true");
		return maper;
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/getmsg")
	public List<Msg> getmsg(@RequestBody Map<String, String> us) {		
		List<Msg> msg = msgrepo.getMsg(us.get("rec"),us.get("sen"));
		return msg;
	}
	@CrossOrigin(origins = "*")
	 @DeleteMapping("/DeleteUser/{id}")
	  void deleteUser(@PathVariable Long id) {
		userrepo.deleteById(id);
	  }
	
	
	@CrossOrigin(origins = "*")
	@GetMapping("/User/{id}")
	@ResponseBody
	public User retriveUser(@PathVariable("id") Long id) {
		
		return userrepo.findByByIdCust(id);
	}
	@PutMapping("/modifyUser/{id}")
	 public ResponseEntity<User> updateUser(@RequestBody User cat,@PathVariable("id") Long id) {  
		Optional<User> userdata=userrepo.findById(id);
		if(userdata.isPresent()) {
			User user=userdata.get();
			user.setPrenom(cat.getPrenom());
			user.setNom(cat.getNom());
			user.setEmail(cat.getEmail());
			user.setTel(cat.getTel());
			user.setSite(cat.getSite());
			user.setPassword(cat.getPassword());
			user.setRole(cat.getRole());
			user.setLogoutdate(cat.getLogoutdate());

			
		
			return new ResponseEntity<>(userrepo.save(user),HttpStatus.OK);
			
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
        
    }  
	@PostMapping("/InsertUser")
	@ResponseBody
	public User InsertUser(@RequestBody User use) {
		return userrepo.save(use);
	}		 
	
	
	
	
	@CrossOrigin(origins = "*")
	@GetMapping("/stat")
	HashMap<String, List> stat() {
		List<Long> equoi = new ArrayList<>();
		List<Long> Monay = new ArrayList<>();
		List<Long> nbrs = new ArrayList<>();
		HashMap<String, List> map = new HashMap<>();
		String thisYear = Year.now().toString();		
		String cv=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String YeMo=cv.substring(0, 8);
		try {
			nbrs.add(receptionrepo
					.CountReception(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(YeMo+ "01 00:00:00"),
							new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(YeMo+"30 00:00:00")));
			System.out.print("***2****");
			nbrs.add(receptionrepo
					.CountReception(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-01-01 00:00:00"),
							new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-12-31 00:00:00")));
			///////////
			System.out.print("***3****");
			nbrs.add(ParcRoulancerepo.CountParcRoulant(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(YeMo+ "01 00:00:00"),
					new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(YeMo+ "30 00:00:00")));
			System.out.print("***4****");
			nbrs.add(ParcRoulancerepo.CountParcRoulant(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-01-01 00:00:00"),
					new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-12-31 00:00:00")));
			
             // equoi => ParcRoulancerepo nb all months
			equoi.add(ParcRoulancerepo.CountParcRoulant(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-01-01 00:00:00"),
					new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-02-01 00:00:00")));
			equoi.add(ParcRoulancerepo.CountParcRoulant(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-02-01 00:00:00"),
					new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-03-01 00:00:00")));
			equoi.add(ParcRoulancerepo.CountParcRoulant(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-03-01 00:00:00"),
					new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-04-01 00:00:00")));
			equoi.add(ParcRoulancerepo.CountParcRoulant(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-04-01 00:00:00"),
					new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-05-01 00:00:00")));
			equoi.add(ParcRoulancerepo.CountParcRoulant(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-05-01 00:00:00"),
					new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-06-01 00:00:00")));
			equoi.add(ParcRoulancerepo.CountParcRoulant(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-06-01 00:00:00"),
					new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-07-01 00:00:00")));
			equoi.add(ParcRoulancerepo.CountParcRoulant(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-07-01 00:00:00"),
					new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-08-01 00:00:00")));
			equoi.add(ParcRoulancerepo.CountParcRoulant(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-08-01 00:00:00"),
					new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-09-01 00:00:00")));
			equoi.add(ParcRoulancerepo.CountParcRoulant(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-09-01 00:00:00"),
					new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-10-01 00:00:00")));
			equoi.add(ParcRoulancerepo.CountParcRoulant(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-10-01 00:00:00"),
					new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-11-01 00:00:00")));
			equoi.add(ParcRoulancerepo.CountParcRoulant(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-11-01 00:00:00"),
					new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-12-01 00:00:00")));
			equoi.add(ParcRoulancerepo.CountParcRoulant(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-12-01 00:00:00"),
					new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-12-31 00:00:00")));

			// COut receptionrepo
			Monay.add(receptionrepo
					.CountReception(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-01-01 00:00:00"),
							new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-02-01 00:00:00")));
			Monay.add(receptionrepo
					.CountReception(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-02-01 00:00:00"),
							new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-03-01 00:00:00")));
			Monay.add(receptionrepo
					.CountReception(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-03-01 00:00:00"),
							new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-04-01 00:00:00")));
			Monay.add(receptionrepo
					.CountReception(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-04-01 00:00:00"),
							new SimpleDateFormat("yyyy-MM-dd").parse(thisYear + "-05-01 00:00:00")));
			Monay.add(receptionrepo
					.CountReception(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-05-01 00:00:00"),
							new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-06-01 00:00:00")));
			Monay.add(receptionrepo
					.CountReception(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-06-01 00:00:00"),
							new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-07-01 00:00:00")));
			Monay.add(receptionrepo
					.CountReception(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-07-01 00:00:00"),
							new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-08-01 00:00:00")));
			Monay.add(receptionrepo
					.CountReception(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-08-01 00:00:00"),
							new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-09-01 00:00:00")));
			Monay.add(receptionrepo
					.CountReception(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-09-01 00:00:00"),
							new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-10-01 00:00:00")));
			Monay.add(receptionrepo
					.CountReception(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-10-01 00:00:00"),
							new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-11-01 00:00:00")));
			Monay.add(receptionrepo
					.CountReception(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-11-01 00:00:00"),
							new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-12-01 00:00:00")));
			Monay.add(receptionrepo
			.CountReception(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-12-01 00:00:00"),
							new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(thisYear + "-12-31 00:00:00")));
			
			
			//[reception_month,reception_year,parc_month,reception_yera]
			System.out.print("*****************");
			System.out.print(equoi);
			System.out.print(Monay);
			map.put("parcroulancedata", equoi);
			map.put("receptiondata", Monay);
			map.put("nbrs", nbrs);

		} catch (ParseException e) {
			return map;
		}

		
		return map;
	}
	
}
