package study.hoomin.querydsl.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import study.hoomin.querydsl.dto.MemberSearchCondition;
import study.hoomin.querydsl.dto.MemberTeamDto;

public interface MemberRepositoryCustom {
	List<MemberTeamDto> search(MemberSearchCondition condition);
	Page<MemberTeamDto> searchPageSimple(MemberSearchCondition condition, Pageable pageable);
	Page<MemberTeamDto> searchPageComplex(MemberSearchCondition condition, Pageable pageable);
}
