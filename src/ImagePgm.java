import java.io.*;
import java.util.*;
public class ImagePgm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("Image");
//String path= "C:\Users\bb\Downloads\peppers512x512.pgm";

//String chaine="";
Vector<Integer> carac=new Vector();
String fichier ="lena512x512.pgm";
String l1="";
String l2="";
String l3="";
//lecture du fichier texte	
try{
	InputStream ips=new FileInputStream(fichier); 
	InputStreamReader ipsr=new InputStreamReader(ips);
	BufferedReader br=new BufferedReader(ipsr);
	String ligne;
	
	int numligne=0;
	while ((ligne=br.readLine())!=null){numligne++;
		System.out.println(ligne);
		if(numligne==1){l1=ligne;}
		if(numligne==2){l2=ligne;}
		if(numligne==3){l3=ligne;}
		if(numligne>3){
		carac.addElement(Integer.valueOf(ligne));}
	}
	br.close(); 
	for(int j=0; j< carac.size();j++){
	System.out.println(carac.get(j));
	}
}		
catch (Exception e){
	System.out.println(e.toString());
}
Vector<Integer> histo= new Vector(); 
for(int a=0;a<256;a++){
	histo.addElement(0);
	for(int b=0;b<carac.size();b++){
		if(carac.get(b)==a){histo.setElementAt(histo.get(a)+1,a);}
	}
}
int r;
// renvoie l'histogramme
for(int a=0;a<256;a++){
		r=histo.get(a);
		System.out.println("Nombre de pixels de valeur" +a+": "+r);
}

//création ou ajout dans le fichier texte
try {
	String fichier2="histogramme.pgm";
	String chaine="";
	FileWriter fw = new FileWriter (fichier2);
	BufferedWriter bw = new BufferedWriter (fw);
	PrintWriter fichierSortie = new PrintWriter (bw);
	chaine=l1+"\n"+l2+"\n"+l3+"\n";
	for(int s=0; s<histo.size();s++){
		chaine+=histo.get(s)+"\n";
	}
		fichierSortie.println (chaine+"\n test de lecture et écriture !!"); 
	fichierSortie.close();
	System.out.println("Le fichier " + fichier2 + " a été créé!"); 
}
catch (Exception e){
	System.out.println(e.toString());
}	
	}
}
