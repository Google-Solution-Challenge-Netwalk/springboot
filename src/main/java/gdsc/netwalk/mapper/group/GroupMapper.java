package gdsc.netwalk.mapper.group;

import gdsc.netwalk.common.vo.CustomList;
import gdsc.netwalk.common.vo.CustomMap;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GroupMapper {
    void registerGroup(CustomMap param);
    CustomList<CustomMap> selectGroupListByCreateUserNo(int createUserNo);
    CustomList<CustomMap> selectParticipateGroupList(CustomMap param);
    void participateGroup(CustomMap param);
    int isExistParticipatedByUserNo(CustomMap param);
    CustomList<CustomMap> selectCategoryGroup(CustomMap param);
    CustomList<CustomMap> selectGroupInUsers(int groupNo);
    void updateGroupActivityST(CustomMap param);
    void updateParticipantCnt(CustomMap param);
}
