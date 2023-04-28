public class chefEntreprise extends employe {

private int chiffreAffaire=30000; 


public chefEntreprise (String sonNom, String sonPrenom, int sonAge, String saDateEntre) {
super(sonNom, sonPrenom, sonAge, saDateEntre); 
}

public double salaire () {
return chiffreAffaire/100*20+1000+super.salaire();
} 

public String toString () {
return "Intitulé du poste : chefEntreprise, "+nom+" "+prenom+" "+age+" ans Entré dans l'entreprise le: "+dateEntre+" salaire : "+salaire()+" euros"; }

}