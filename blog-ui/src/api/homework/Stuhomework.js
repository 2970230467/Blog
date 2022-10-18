import request from '@/utils/request'

// 查询查看作业列表
export function listStuhomework(query) {
  return request({
    url: '/homework/markstuhomework/list',
    method: 'get',
    params: query
  })
}

// 查询查看作业详细
export function getStuhomework(id) {
  return request({
    url: '/homework/markstuhomework/' + id,
    method: 'get'
  })
}

// 新增查看作业
export function addStuhomework(data) {
  return request({
    url: '/homework/markstuhomework',
    method: 'post',
    data: data
  })
}

// 修改查看作业
export function updateStuhomework(data) {
  return request({
    url: '/homework/markstuhomework',
    method: 'put',
    data: data
  })
}

// 删除查看作业
export function delStuhomework(id) {
  return request({
    url: '/homework/markstuhomework/' + id,
    method: 'delete'
  })
}
