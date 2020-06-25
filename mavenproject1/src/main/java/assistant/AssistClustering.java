/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assistant;

import control.HoaDonBanHangDAO;
import control.MatHangDAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.MatHang;
import model.*;
/**
 *
 * @author tuan2
 */


public class AssistClustering {
    private HoaDonBanHangDAO hoaDonDAO = new HoaDonBanHangDAO();
    private MatHangDAO matHangDAO = new MatHangDAO();
    
    

    public ArrayList<Pair> getN_C_2(int n,ArrayList<RecordSanPham> listMH){
        ArrayList<Pair> res = new ArrayList<>();
        for(int i  = 0 ; i < n ; i ++ ){
            for(int j = i + 1 ; j < n ; j++){
                res.add(new Pair(listMH.get(i).getPham().getIdMatHang(), listMH.get(j).getPham().getIdMatHang()));
                res.add(new Pair(listMH.get(j).getPham().getIdMatHang(), listMH.get(i).getPham().getIdMatHang()));
            }
        }
        return res; 
    }
    
    public  Map<Pair,Double> getsimiler(ArrayList<MatHang> listMH ,int MinNumber){
        Map<Pair,Double> probabilityMH = new HashMap(); 
        Map<Integer , Integer > countMH = new HashMap<>();
        for( int i = 0 ; i < listMH.size() ; i++){
            for( int j = i + 1 ; j < listMH.size() ; j++ ){
                Pair tmp = new Pair(listMH.get(j).getIdMatHang() , listMH.get(i).getIdMatHang());
                probabilityMH.put(tmp,0.0 );
                tmp = new Pair(listMH.get(i).getIdMatHang() , listMH.get(j).getIdMatHang());
                probabilityMH.put(tmp,0.0);
                
            }
            
        }
        for(MatHang i : listMH){
          //  System.out.println(i.getIdMatHang());
            countMH.put(i.getIdMatHang(),0);
        }
        HoaDonBanHangDAO hoaDonBanHangDAO = new  HoaDonBanHangDAO();
        ArrayList<HoaDonBanHang> listHoaDonBanHang = new ArrayList<HoaDonBanHang>();
        listHoaDonBanHang = hoaDonBanHangDAO.getHoaDonBanHangAndSPDB();
        for(HoaDonBanHang i : listHoaDonBanHang){
            for(RecordSanPham j : i.getListSanPhamSelected()){
                countMH.put(j.getPham().getIdMatHang(), countMH.get( j.getPham().getIdMatHang()) + 1 );
            }
            ArrayList<Pair> pairMH = getN_C_2(i.getListSanPhamSelected().size(), i.getListSanPhamSelected());
//            System.out.println(" assa "+pairMH.size());
            for(Pair j : pairMH){
//                System.out.println(j.getIdX() + "      " + j.getIdY() );
                probabilityMH.put(j, probabilityMH.get(j) + 1);
            }
        }
        for(Pair i : probabilityMH.keySet()){
            if(probabilityMH.get(i) < MinNumber || countMH.get(i.getIdX()) == 0){
                probabilityMH.put(i, 0.0);
            }
            else{
                probabilityMH.put(i, probabilityMH.get(i)/ countMH.get(i.getIdX()));
            }
        }
//        for( Pair i : probabilityMH.keySet()){
//            System.out.println(i.getIdX() + ' ' + i.getIdY() + ' ' + probabilityMH.get(i));
//        }
//        
//        listHoaDonBanHang  =new  HoaDonBanHangDAO().getHoaDonBanHangs();
        return probabilityMH;
    }
    
//    public static void main(String[] args) {
//        Map<Pair,Double> k = new AssistClustering().getsimiler(2);
//        for(Pair i : k.keySet()){
//            System.out.println(i.getIdX() + " " + i.getIdY() + " " + k.get(i));
//        }
//    }
    
}
