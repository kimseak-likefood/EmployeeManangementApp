package kh.edu.paragoniu.helloworldapp.converter;

import kh.edu.paragoniu.helloworldapp.models.Department;
import kh.edu.paragoniu.helloworldapp.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DepartmentConverter implements Converter<String, Department> {

    @Autowired
    private DepartmentService deptService;

    @Override
    public Department convert(String id) {
        // When form submits department id "2",
        // this converts it to the actual Department object
        if (id == null || id.isEmpty()) {
            return null;
        }
        return deptService.findById(Long.parseLong(id));
    }
}
