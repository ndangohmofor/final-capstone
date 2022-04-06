package com.techelevator.dao;

import com.techelevator.model.Machine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class JdbcMachineDao implements MachineDao {

    JdbcTemplate template;

    @Autowired
    public JdbcMachineDao(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Machine> getMachines() {
        return template.query("select * from machine;", new MachineRowMapper());
    }

    @Override
    public List<Machine> getMachinesByName(String machineName) {
        return template.query("select * from machine where machine_name ilike ?", new MachineRowMapper(), "%" + machineName + "%");
    }

    @Override
    public List<Machine> getMachinesByType(String machineType) {
        return template.query("select * from machine where machine_type ilike ?", new MachineRowMapper(), "%" + machineType + "%");
    }

    @Override
    public List<Machine> getMachineUsage(){
        return template.query("select machine_name, count(date) as usage from equipment_log join machine  on equipment_log.machine_id = machine.id where machine_name ilike ?",new MachineRowMapper());
    }


    @Override
    public void addMachine(String machineName, String machineType, String machineReference) {
        String sql = "insert into machine(machine_name, machine_type, machine_reference) values (?,?,?)";
        template.update(sql, machineName, machineType, machineReference);
    }


}
class MachineRowMapper implements RowMapper<Machine> {

    @Override
    public Machine mapRow(ResultSet result, int i) throws SQLException {
        Machine machine = new Machine();

        machine.setId(result.getLong("id"));
        machine.setMachineName(result.getString("machine_name"));
        machine.setMachineType(result.getString("machine_type"));
        machine.setMachineReference(result.getString("machine_reference"));
        return machine;
    }
}

