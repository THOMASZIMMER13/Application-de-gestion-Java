public class manutentionnaire extends employe {

int nbH =140;

public manutentionnaire (String sonNom, String sonPrenom, int sonAge, String saDateEntre) {
super(sonNom, sonPrenom, sonAge, saDateEntre); 
}

public double salaire () {
return nbH*5+200+super.salaire();
} 

public String toString () {
return "Intitulé du poste : manutentionnaire, "+nom+" "+prenom+" "+age+" ans Entré dans l'entreprise le: "+dateEntre+" salaire : "+salaire()+" euros"; }

}