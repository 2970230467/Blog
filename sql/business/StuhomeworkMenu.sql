-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('查看作业', '2000', '1', 'Stuhomework', 'homework/Stuhomework/index', 1, 0, 'C', '0', '0', 'homework:Stuhomework:list', '#', 'admin', sysdate(), '', null, '查看作业菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('查看作业查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'homework:Stuhomework:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('查看作业新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'homework:Stuhomework:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('查看作业修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'homework:Stuhomework:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('查看作业删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'homework:Stuhomework:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('查看作业导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'homework:Stuhomework:export',       '#', 'admin', sysdate(), '', null, '');