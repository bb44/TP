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

//lecture du fichier texte	
try{
	InputStream ips=new FileInputStream(fichier); 
	InputStreamReader ipsr=new InputStreamReader(ips);
	BufferedReader br=new BufferedReader(ipsr);
	String ligne;
	int numligne=0;
	while ((ligne=br.readLine())!=null){numligne++;
		System.out.println(ligne);
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
/*
//cr�ation ou ajout dans le fichier texte
try {
	FileWriter fw = new FileWriter (fichier);
	BufferedWriter bw = new BufferedWriter (fw);
	PrintWriter fichierSortie = new PrintWriter (bw); 
		fichierSortie.println (chaine+"\n test de lecture et �criture !!"); 
	fichierSortie.close();
	System.out.println("Le fichier " + fichier + " a �t� cr��!"); 
}
catch (Exception e){
	System.out.println(e.toString());
}	*/	
	}
}
