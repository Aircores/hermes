package com.aircore.hermes.support.dao;

import com.aircore.hermes.support.domain.SmsRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 短信记录Dao
 * @author aircore@belink.com
 */
public interface SmsRecordDao extends JpaRepository<SmsRecord, Long> {

    /**
     * 通过日期和手机号找到发送记录
     *
     * @param phone
     * @param sendDate
     * @return
     */
    List<SmsRecord> findByPhoneAndSendDate(Long phone, Integer sendDate);

}
