package cn.wmkfe.bookmanage.dao;

import cn.wmkfe.bookmanage.model.Type;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TypeMapper {
    int add(Type type);
    int delete(Integer[] typeId);
    int update(Type type);
    Type getByTypeId(Integer typeId);
    List<Type> getList(@Param("Type") Type type,
                       @Param("keyword") String keyword,
                       @Param("from") Integer from,
                       @Param("pageSize") Integer pageSize);
    int getTotal(@Param("keyword") String keyword);

    List<Type> getListAll();
}