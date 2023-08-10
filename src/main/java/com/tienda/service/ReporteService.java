/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.service;

import java.io.IOException;
import java.util.Map;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author pauvi
 */
public interface ReporteService {

  public ResponseEntity<Resource>
          generaReporte(
                      String reporte, //El nombre del archivo llamado .jaspier
                      Map<String, Object> parametros, //Los parametros del reporte, si tiene parametros
                      String tipo  //El tipo de reportes, pdf,Xls,csv
          )throws IOException;
}
