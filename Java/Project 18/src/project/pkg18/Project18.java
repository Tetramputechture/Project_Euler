/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.pkg18;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author Nick
 */
public class Project18 {
    
    public static int sumAtRow(int rowData[][], int rowNum) {
        for (int i = 0; i < rowData[rowNum].length; i++) {
            rowData[rowNum][i] += Math.max(rowData[rowNum+1][i], rowData[rowNum+1][i+1]);
        }
        if (rowData[rowNum].length == 1) {
            return rowData[rowNum][0];
        } else {
            return sumAtRow(rowData, rowNum-1);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        String[][] sTri;
        int[][] tri;

        List<String> lines = Files.readAllLines(Paths.get("triangle.txt"));

        sTri = new String[lines.size()][]; 

        for (int i = 0; i < lines.size(); i++){
          sTri[i] = lines.get(i).split(" "); 
        }
        
        tri = new int[sTri.length][];
        
        for (int r = 0; r < sTri.length; r++) {
            tri[r] = new int[sTri[r].length];
            for (int c = 0; c < sTri[r].length; c++) {
                tri[r][c] = Integer.parseInt(sTri[r][c]);
            }
        }
        System.out.println(sumAtRow(tri, tri.length-2));
    }
}
