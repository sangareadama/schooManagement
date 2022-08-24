package com.sang.school.schoolManagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sang.school.schoolManagement.domain.Classe;
import com.sang.school.schoolManagement.domain.Cours;
import com.sang.school.schoolManagement.domain.Eleve;
import com.sang.school.schoolManagement.domain.Enseignant;
import com.sang.school.schoolManagement.domain.Note;
import com.sang.school.schoolManagement.domain.NoteEleve;
import com.sang.school.schoolManagement.domain.TypeNote;
import com.sang.school.schoolManagement.domain.Utilisateur;
import com.sang.school.schoolManagement.model.ModelNote;
import com.sang.school.schoolManagement.service.IClasseService;
import com.sang.school.schoolManagement.service.ICoursService;
import com.sang.school.schoolManagement.service.IEnseignantService;
import com.sang.school.schoolManagement.service.INoteEleveService;
import com.sang.school.schoolManagement.service.INoteService;
import com.sang.school.schoolManagement.service.ITypeNoteService;
import com.sang.school.schoolManagement.service.IUtilisateurService;

@Controller
@RequestMapping("/")
public class NoteController {
	
	@Autowired
	IClasseService  iClasseService;
	
	@Autowired
	ClasseController classeController;
	
	@Autowired
	INoteService iNoteService;
	
	@Autowired
	ITypeNoteService iTypeNoteService;
	
	@Autowired
	ICoursService iCoursService;
	
	@Autowired
	IUtilisateurService utilisateurService;
	
	@Autowired
	IEnseignantService iEnseignantService;
	
	@Autowired
	INoteEleveService iNoteEleveService;
	
	
	// recupere l'enseignant qui est connecté
	public Enseignant EnseignantConnecte() {
		
		    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String user=auth.getName();
		    Utilisateur ut= utilisateurService.rechercherUtilisateurParEmail(user);
		    
		    Enseignant ens = iEnseignantService.rechercherEnseignantParEmail(ut.getEmail());
		
		return ens;		
	}
	
	List<Cours> cours;
	List<Eleve> eleves;
	Classe classe;
	Long defClasse;
	@RequestMapping("enseignant/classe/note")
	public String teachersNotes(Model model ,Long id) {
		
		 if(id==null) { 
			  id=defClasse;
			  } 
		  else {  
			  defClasse=id;
		  }
		
		Enseignant enseignant = EnseignantConnecte(); 
		
		classe = iClasseService.rechercherClasseParId(id);
		
		List<Note> noteEns = iNoteService.findByEnseignantId(enseignant.getId());
		
		List<Note> notesEngClasse= new ArrayList<Note>();
		
		for (Note note : noteEns) {
			
           if(classe.equals(note.getClasse())) {
				
				notesEngClasse.add(note); 
			}	
		}	 
		
		model.addAttribute("notes",notesEngClasse);
		
		    cours = classeController.ListeDesCoursDeLEnseignantDeLaClase(classe);
		
		    eleves = classeController.ListeEleveParClasse(classe);
		 
		//model.addAttribute("cours",cours);
		
		//model.addAttribute("eleves",eleves);
			
	
	   // model.addAttribute("cours",cours);
		
		return "adminEnseignant/note/liste_notes";
	}
	

	@RequestMapping("enseignant/classe/note/addNote")
	public String addNotes(Model model) {
		
		List<TypeNote> tn =  iTypeNoteService.listeTypeNote();
		
		model.addAttribute("matiere",cours);
		
		model.addAttribute("typeNote",tn);
		
		model.addAttribute("eleves",eleves);
		
		model.addAttribute("note",new ModelNote());
		//List<Eleve> eleves = classeController.ListeEleveParClasse(cl);
		
		
		return  "adminEnseignant/note/add_notes";
		
	}
	@RequestMapping("enseignant/classe/note/save")
	public String saveNotes(@RequestParam("noteListe") List<Double> noteListe,ModelNote modelNote) {
		
		TypeNote tn = iTypeNoteService.rechercherTypeNoteParId(modelNote.getTypeNoteId());
		
		Cours cr = iCoursService.rechercherCoursParId(modelNote.getCoursId());
		
		Enseignant enseignant = EnseignantConnecte();
		
		List<Eleve> Eleves = eleves;
		
		Note note = iNoteService.enregistrerNote(tn, cr, enseignant,classe, modelNote.getDateNote(), modelNote.getHeureDebut(), modelNote.getHeureFin());
		
		for (int i = 0; i < noteListe.size(); i++) {
			
			iNoteEleveService.enregistrerNoteEleve(note, Eleves.get(i), noteListe.get(i));
		}
		
		return  "redirect:/enseignant/classe/note";	
	}
	
	Long def;
	@RequestMapping("enseignant/classe/note/view")
	public String NewsNotes(Model model,Long id) {
		
		  if(id==null) { 
			  id=def;
			  } 
		  else {  
			  def=id;
		  }
		  
		List<NoteEleve> noteDesEleves = iNoteEleveService.findByNoteId(id);
		
		model.addAttribute("noteEleve",noteDesEleves);
	 
	   return  "adminEnseignant/note/liste_noteEleve";
	}
		
	
	@RequestMapping("enseignant/classe/note/edit")
	public String editNotes(Model model,Long id) {
		
		NoteEleve noteDesEleve= iNoteEleveService.rechercherNoteEleveParId(id);
		
		
		model.addAttribute("noteEleve",noteDesEleve); 
		 
		return  "adminEnseignant/note/edit_note";
	}
	
	@RequestMapping("enseignant/classe/note/update")
	public String updateNotes(NoteEleve noteEleve) {
		
		iNoteEleveService.modifierNoteEleveId(noteEleve.getId(), noteEleve.getValeurNote());
		
		return   "redirect:/enseignant/classe/note/view";
		
	}

}
