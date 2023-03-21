package ma.Bankati.jdbc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
   public class Credit {
   private  Double id ;
   private Double capitale_emprunte;
   private Integer nbr_mois ;
   private Double Taux_Mensuel;
   private String nom_demandeur ;
   private Double mensualite ;

   @Override
   public String toString() {
      var creditStr="============================================================= \n";
      creditStr+="=> Credit nº "+getId()+"                                         \n";
      creditStr+="=> Nom de ddemandeur de Credit : "+getNom_demandeur()+"          \n";
      creditStr+="-----------------------------------------------------------------\n";
      creditStr+="=> Capitale Emprunte           :"+getCapitale_emprunte()+"       \n";
      creditStr+="=> Nombre de Mois              :"+getNbr_mois()+"Mois            \n";
      creditStr+="=> Capitale Emprunte           :"+getTaux_Mensuel()+"            \n";
      creditStr+="-----------------------------------------------------------------\n";
      creditStr+="=> Mentualite            :      "
              +(getMensualite()==0.0? " Non Calculer " : getMensualite()+ "DH/Mois")+"\n";
       creditStr+="================================================================\n";

      return creditStr;
   }
}
