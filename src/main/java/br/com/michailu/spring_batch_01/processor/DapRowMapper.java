package br.com.michailu.spring_batch_01.processor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.michailu.spring_batch_01.modelo.Dap;

public class DapRowMapper implements RowMapper<Dap> {

    public static final String CPF = "cpf";
    public static final String NOME = "nome";
    public static final String MAE = "mae";
    public static final String DN = "dn";
    public static final String NIS = "nis";
    public static final String DAP = "dap";
    public static final String DT_VALIDADE_DAP = "dt_validade_dap";

    public Dap mapRow(ResultSet rs, int rowNum) throws SQLException {
        Dap dap = new Dap();
        dap.setCpf(rs.getString(CPF));
        dap.setNome(rs.getString(NOME));
        dap.setMae(rs.getString(MAE));
        dap.setDn(rs.getString(DN));
        dap.setNis(rs.getString(NIS));
        dap.setDap(rs.getString(DAP));
        dap.setDt_validade_dap(rs.getString(DT_VALIDADE_DAP));
        return dap;
    }
}