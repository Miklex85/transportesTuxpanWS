package com.tux.model;

import com.tux.dto.ContpaqFactura;
import com.tux.dto.ContpaqFolioDigital;
import com.tux.model.dao.FolioDigitalDAO;
import com.tux.utils.FechaUtils;
import java.math.BigDecimal;

/**
 *
 * @author Mike
 */
public class FolioDigitalBO {

    public boolean registrarFolioDigital(ContpaqFactura factura) {
        ContpaqFolioDigital folio;
        FolioDigitalDAO folioDigitalDAO = new FolioDigitalDAO();
        boolean hecho = false;
        try {
            folio = new ContpaqFolioDigital();
            folio.setCidfoldig(folioDigitalDAO.getMaxId());
            folio.setCiddoctode(factura.getCiddocum02());
            folio.setCidcptodoc(factura.getCidconce01());
            folio.setCiddocto(factura.getCiddocum01());
            folio.setCiddocaldi(BigDecimal.valueOf(0));
            //folio.setCidfirmarl();
            //folio.setCnoorden();
            //folio.setCserie();
            folio.setCfolio(BigDecimal.valueOf(factura.getCfolio()));
            //folio.setCnoaprob();
            //folio.setCfecaprob();
            folio.setCestado(BigDecimal.valueOf(1));
            folio.setCentregado(BigDecimal.valueOf(0));
            folio.setCfechaemi(FechaUtils.getFechaActual());
            //folio.setChoraemi();
            //folio.setCemail();
            //folio.setCarchdidis();
            //folio.setCidcptoori();
            //folio.setCfechacanc();
            //folio.setChoracanc();
            folio.setCestrad(BigDecimal.valueOf(3));
            //folio.setCcadpedi();
            //folio.setCarchcbb();
            //folio.setCinivig();
            //folio.setCfinvig();
            //folio.setCtipo();
            //folio.setCserierec();
            //folio.setCfoliorec();
            folio.setCrfc(factura.getCrfc());
            //folio.setCrazon();
            //folio.setCsisorigen();
            //folio.setCejerpol();
            //folio.setCperpol();
            //folio.setCtipopol();
            //folio.setCnumpol();
            //folio.setCtipoldesc();
            folio.setCtotal(factura.getCtotal());
            //folio.setCaliasbdct();
            //folio.setCcfdprueba();
            //folio.setCdesestado();
            //folio.setCpagadoban();
            //folio.setCdespagban();
            //folio.setCreferen01();
            //folio.setCobserva01();
            //folio.setCcodconcba();
            //folio.setCdesconcba();
            //folio.setCnumctaban();
            //folio.setCfolioban();
            //folio.setCiddocdeba();
            //folio.setCusuautban();
            //folio.setCuuid();
            //folio.setCusuban01();
            //folio.setCautusba01();
            //folio.setCusuban02();
            //folio.setCautusba02();
            //folio.setCusuban03();
            //folio.setCautusba03();
            //folio.setCdescaut01();
            //folio.setCdescaut02();
            //folio.setCdescaut03();
            //folio.setCerrorval();
            //folio.setCacusecan();
            hecho = folioDigitalDAO.crearFolioDigital(folio);
        } catch (Exception e) {
            System.out.println("FolioDigitalBO.registrarFolioDigital:  Ocurrio un error al registrar el folio digital de la factura ");
            e.printStackTrace();
        } finally {
            System.out.println("FolioDigitalBO.registrarFolioDigital: Regresa la siguiente respuesta: " + hecho);
            return hecho;
        }
    }
}
