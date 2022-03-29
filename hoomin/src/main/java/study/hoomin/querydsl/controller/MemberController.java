package study.hoomin.querydsl.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import study.hoomin.querydsl.dto.MemberSearchCondition;
import study.hoomin.querydsl.dto.MemberTeamDto;
import study.hoomin.querydsl.repository.MemberJpaRepository;
import study.hoomin.querydsl.repository.MemberRepository;

@RestController
@RequiredArgsConstructor
public class MemberController {
	private final MemberJpaRepository memberJpaRepository;
	private final MemberRepository memberRepository;

	@GetMapping("/v1/members")
	public List<MemberTeamDto> searchMemberV1(MemberSearchCondition memberSearchCondition) {
		return memberJpaRepository.search(memberSearchCondition);
	}

	@GetMapping("/v2/members")
	public Page<MemberTeamDto> searchMemberV2(MemberSearchCondition memberSearchCondition, Pageable pageable) {
		return memberRepository.searchPageSimple(memberSearchCondition, pageable);
	}

	@GetMapping("/v3/members")
	public Page<MemberTeamDto> searchMemberV3(MemberSearchCondition memberSearchCondition, Pageable pageable) {
		return memberRepository.searchPageComplex(memberSearchCondition, pageable);
	}
}
