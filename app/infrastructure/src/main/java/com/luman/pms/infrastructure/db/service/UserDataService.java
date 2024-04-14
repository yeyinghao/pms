package com.luman.pms.infrastructure.db.service;

import com.luman.pms.domain.dp.User;
import com.luman.pms.infrastructure.db.dataobject.UserPO;
import com.luman.smy.dal.service.DataService;

public interface UserDataService extends DataService<UserPO, User> {
}
