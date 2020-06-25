/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assistant;

import control.MatHangDAO;
import java.util.ArrayList;
import java.util.Map;
import model.MatHang;

/**
 *
 * @author tuan2
 */
public class Clustering {
    public  double calculSimilar_Min(Map<Pair,Double> probabilityMH, ArrayList<MatHang> listMH , MatHang MH){
        double Min = 1.1;
//        System.out.println("xem sao");
//        for(Pair i : probabilityMH.keySet()){
//              Pair tmp = new Pair(MH.getIdMatHang(), 1);
//            if(i.equals(tmp))
//                System.out.println(i.hashCode() + " " + tmp.hashCode()+  " " + probabilityMH.get(i));
//        }
        for(MatHang i : listMH){
            Pair tmp =  new Pair(MH.getIdMatHang(), i.getIdMatHang());
            
            if( probabilityMH.get(tmp) < Min){
                Min = probabilityMH.get(tmp);
            }
        }
        return Min;
    }
    
    

public ArrayList< ArrayList<MatHang> > clustering(double  threshold,int MinNumber,String option){
    ArrayList<MatHang> listMH = new  MatHangDAO().getAllMatHang();
    ArrayList< ArrayList<MatHang> > res = new ArrayList<>();
    Map<Pair,Double> probabilityMH = new AssistClustering().getsimiler(listMH, MinNumber);
    for(MatHang i : listMH){
        if(res.size() == 0){
            ArrayList<MatHang> tmp = new ArrayList<>();
            tmp.add(i);
            res.add(tmp);
        }
        else{
            int index = -1;
            double Max = 0.0;
            int c = 0;
            for(ArrayList<MatHang> j : res){
                double calculer = calculSimilar_Min(probabilityMH, j, i);
                if( Max < calculer ){
                    index = c;
                    Max = calculer;
                }
            }
//                System.out.println(Min);
            if(index == -1 ){
                ArrayList<MatHang> tmp = new ArrayList<>();
                tmp.add(i);
                res.add(tmp);
            }
            else{
                if(Max < threshold){
                    ArrayList<MatHang> tmp = new ArrayList<>();
                    tmp.add(i);
                    res.add(tmp);
                }
                else{
                    res.get(index).add(i);
                    System.out.println("s  ss kkas " + res.get(index).size());
                }
            }
        }
        }
    //for()
    int i = 0;
    while(i < res.size()){
        if(res.get(i).size() == 1) res.remove(i);
        else i++;
    }
    MatHangDAO mhDAO = new MatHangDAO();
    for(i = 0 ; i < res.size() ; i++){
        for(int j = 0 ; j < res.get(i).size() ; j++){
            res.get(i).set(j, mhDAO.getMatHang( res.get(i).get(j).getIdMatHang() ) );
        }
    }
    return res;
    
}


    public static void main(String[] args) {
        Clustering a = new Clustering();
        a.clustering(0.1, 1, "as");
    }
}
