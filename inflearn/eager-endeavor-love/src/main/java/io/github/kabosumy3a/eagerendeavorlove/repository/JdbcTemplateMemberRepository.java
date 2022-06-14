package io.github.kabosumy3a.eagerendeavorlove.repository;

import io.github.kabosumy3a.eagerendeavorlove.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class JdbcTemplateMemberRepository implements MemberRepository{


    private final JdbcTemplate jdbcTemplate ;

    // @Autowired ~ Constructor가 한 개일 경우 생략가능 ~
    public JdbcTemplateMemberRepository(DataSource datasource) {
        jdbcTemplate = new JdbcTemplate(datasource);
    }

    @Override
    public Member save(Member member) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("member").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", member.getName());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        member.setId(key.longValue());

        return member ;
    }

    @Override
    public Optional<Member> findById(Long id) {
        List<Member> rst = jdbcTemplate.query("select * from member where id = ?",
                memberRowMapper(), id);
        return rst.stream().findAny();
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> rst = jdbcTemplate.query("select * from member where name = ?",
                memberRowMapper(), name);
        return rst.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return jdbcTemplate.query("select * from member", memberRowMapper());
    }

    @Override
    public int findNumMembers() {
        return jdbcTemplate.query("select count(*) from member", intRowMapper()).get(0);
    }

    @Override
    public void clearStore() {
        jdbcTemplate.update("delete from member");
    }

    private RowMapper<Integer> intRowMapper(){
        return (rs, rowNum) -> rs.getInt(1);
    }

    private RowMapper<Member> memberRowMapper(){
        return /*new RowMapper<Member>() {
            @Override
            public Member mapRow(ResultSet rs, int rowNum) throws SQLException {

            }*/
                (rs, rowNum) -> {
                  Member member = new Member();
                  member.setId(rs.getLong("id"));
                  member.setName(rs.getString("name"));
                  return member;
                };
    }
}
