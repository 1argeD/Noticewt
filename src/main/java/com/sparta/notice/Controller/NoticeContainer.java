package com.sparta.notice.Controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.notice.domain.NoticeRequestDto;
import com.sparta.notice.domain.Timestamped;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class NoticeContainer extends Timestamped {

}