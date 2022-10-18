-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('作业', '2000', '1', 'leavehomework', 'homework/leavehomework/index', 1, 0, 'C', '0', '0', 'homework:leavehomework:list', '#', 'admin', sysdate(), '', null, '作业菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('作业查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'homework:leavehomework:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('作业新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'homework:leavehomework:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('作业修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'homework:leavehomework:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('作业删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'homework:leavehomework:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('作业导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'homework:leavehomework:export',       '#', 'admin', sysdate(), '', null, '');