import request from '@/utils/request'

// 查询作业列表
export function listLeavehomework(query) {
  return request({
    url: '/homework/leavehomework/list',
    method: 'get',
    params: query
  })
}

// 查询作业详细
export function getLeavehomework(id) {
  return request({
    url: '/homework/leavehomework/' + id,
    method: 'get'
  })
}

// 新增作业
export function addLeavehomework(data) {
  return request({
    url: '/homework/leavehomework',
    method: 'post',
    data: data
  })
}

// 修改作业
export function updateLeavehomework(data) {
  return request({
    url: '/homework/leavehomework',
    method: 'put',
    data: data
  })
}

// 删除作业
export function delLeavehomework(id) {
  return request({
    url: '/homework/leavehomework/' + id,
    method: 'delete'
  })
}
