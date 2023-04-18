public class responsableCommercial extends employe {

int chiffreAffaire=30000; 


public responsableCommercial (String sonNom, String sonPrenom, int sonAge, String saDateEntre) {
super(sonNom, sonPrenom, sonAge, saDateEntre); 
}


public double salaire () {
return chiffreAffaire/100*20+800+super.salaire();
} 

public String toString () {
return "Intitulé du poste : responsable commercial, "+nom+" "+prenom+" "+age+" ans Entré dans l'entreprise le: "+dateEntre+" salaire : "+salaire()+" euros"; }


}