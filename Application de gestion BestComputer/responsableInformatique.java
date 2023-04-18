public class responsableInformatique extends employe {

int chiffreAffaire=30000; 


public responsableInformatique(String sonNom, String sonPrenom, int sonAge, String saDateEntre) {
super(sonNom, sonPrenom, sonAge, saDateEntre); 
}


public double salaire () {
return chiffreAffaire/100*20+800+super.salaire();
} 

public String toString () {
return "Intitulé du poste : responsable informatique, "+nom+" "+prenom+" "+age+" ans Entré dans l'entreprise le: "+dateEntre+" salaire : "+salaire()+" euros"; }

}